function equalSum1([input]) {
    input = input.split(" ").map(Number)

    function getPartitions(input, num) {
        input.push(num);
        input.sort((a,b)=>b-a);
        let setA = 0, setB = 0;
        setA += input[0];
        for (let i = 1; i < input.length; i++) {
            if ((setA <= setB && input[i] > 0) || ( setA >= setB && input[i] < 0)) setA += input[i];
            else setB += input[i];
        }
        if(setA==setB) return true;
        else return false;
    }

    if(getPartitions(input,13)) console.log("Yes")
    else {
        input.splice(input.indexOf(13),1);
        if(getPartitions(input, -13)) console.log("Yes")
        else console.log("No")
    }
}


function equalSum([input]) {
    input = input.split(" ").map(Number)
    if(input[0]+input[1]+input[2]==13) console.log("Yes")
    else  if(-input[0]+input[1]+input[2]==13) console.log("Yes")
    else  if(-input[0]+input[1]-input[2]==13) console.log("Yes")
    else  if(input[0]-input[1]+input[2]==13) console.log("Yes")
    else  if(-input[0]-input[1]+input[2]==13) console.log("Yes")
    else  if(input[0]-input[1]-input[2]==13) console.log("Yes")
    else  if(-input[0]-input[1]-input[2]==13) console.log("Yes")
    else  if(input[0]+input[1]-input[2]==13) console.log("Yes")
    else console.log("No")
}

equalSum1(["0 0 0"]);
