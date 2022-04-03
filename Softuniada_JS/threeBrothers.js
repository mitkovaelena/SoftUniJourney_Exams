function threeBrothers(input) {
    input = input[0].split('\n')
        let n = input.shift();
    for(let i of input){
        let gifts = i.split(" ").map(Number).sort((a,b)=>b-a);
        let sum = gifts.reduce((a,b) => a+b);
        sum /= 3;
        if(sum != Math.floor(sum)) {
            console.log("No");
            break;
        }

        let setA = gifts[0], setB = 0, setC = 0;
       
            console.log("Yes")
            console.log("No")
        }
}

threeBrothers(["3\n4 5 2 5 3 4 2 5\n1 2 3\n3 3 3"])