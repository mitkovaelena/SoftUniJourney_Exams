function min3Numbers(input){
let n = Number(input.shift());
input = input.sort((a,b)=>a-b);
    for (let i = 0; i < Math.min(3, input.length); i++) {
 console.log(input[i])
    }
}

min3Numbers(["100","22", "345", "2"])