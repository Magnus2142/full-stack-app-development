<template>
  <div>
      <div class="calculator">
      <div class="display">{{current || "0"}}</div>
      <div @click="clear" class="btn">C</div>
      <div @click="sign" class="btn">+/-</div>
      <div @click="percent" class="btn">%</div>
      <div @click="divide" class="btn operator">/</div>
      <div @click="append('7')" class="btn">7</div>
      <div @click="append('8')" class="btn">8</div>
      <div @click="append('9')" class="btn">9</div>
      <div @click="times" class="btn operator">x</div>
      <div @click="append('4')" class="btn">4</div>
      <div @click="append('5')" class="btn">5</div>
      <div @click="append('6')" class="btn">6</div>
      <div @click="minus" class="btn operator">-</div>
      <div @click="append('1')" class="btn">1</div>
      <div @click="append('2')" class="btn">2</div>
      <div @click="append('3')" class="btn">3</div>
      <div @click="plus" class="btn operator">+</div>
      <div @click="append('0')" class="btn zero">0</div>
      <div @click="dot" class="btn">.</div>
      <div @click="equal" class="btn operator">=</div>  
    </div>  
    <textarea id="log" cols="30" rows="10"></textarea>
  </div>
</template>

<script>
export default {
  data(){
    return {
      previous: null,
      current: "",
      operator: null,
      operatorClicked: false,
      log: "",
      operation: '',
    }
  },
  methods: {
    clear(){
      this.current = "";
    },
    sign(){
      this.current = this.current.charAt(0) == "-" ? this.current.slice(1) : `-${this.current}`;
    },
    percent(){
      this.current = `${parseFloat(this.current) / 100 }`
    },
    append(number){
      if(this.operatorClicked){
        this.current = '';
        this.operatorClicked = false;
      }
      this.current = `${this.current}${number}`
    },
    dot(){
      if(this.current.indexOf('.') === -1){
        this.append('.');
      }
    },
    setPrevious(){
      this.previous = this.current;
      this.operatorClicked = true;
    },
    divide(){
      this.operator = (a, b) =>  a/b;
      this.operation = '/';
      this.setPrevious();
    },
    times(){
      this.operator = (a, b) =>  a*b;
      this.operation = '*';
      this.setPrevious();
    },
    minus(){
      this.operator = (a, b) =>  a-b;
      this.operation = '-';      
      this.setPrevious();
    },
    plus(){
      this.operator = (a, b) =>  a+b;
      this.operation = '+';
      this.setPrevious();
    },
    async equal(){
      if(this.previous != null){
        let a = this.previous;
        let b = this.current;
        document.getElementById('log').innerHTML += `${a} ${this.operation} ${b} = ${this.operator(parseInt(a, 10), parseInt(b, 10))}\n`;
        
        this.previous = null;


        let calculation = {
          a: a,
          b: b,
          operation: this.operation,
          answer: ""
        }

        let url= "http://localhost:8080/calculations";

        let options = {
          method: "POST",
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(calculation)
        };

        let result = await fetch(url, options)
          .then(response => response.json())
          .catch(error => console.log(error));
        
        console.log(result.answer);
        let resultSplit = result.answer.split(".");
        if(parseInt(resultSplit[1], 10) === 0){
          this.current = resultSplit[0];
        }else{
          this.current = result.answer;
        }
      }
    },
  }

}
</script>


<style scoped>

.calculator {
  width: 400px;
  margin: 0 auto;
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-auto-rows: minmax(50px, auto);
}

.display {
  font-size: 45px;
  grid-column: 1 / 5;
  background-color: #333;
  color: white;
}

.zero {
  grid-column: 1 / 3;
}

.btn {
  background-color: #f2f2f2;
  border: 1px solid #999;
  display: flex;
  align-items: center;
  justify-content: center;
}

.btn:hover {
  cursor: pointer;
}

.operator {
  background-color: orange;
  color: white;
}
</style>
