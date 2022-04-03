function snake(input) {
    let n = Number(input.shift())
    let cube = [];
    let startX = 0;
    let startY = 0;
    let startZ = 0;
    for (let i = 0; i < n; i++) {
        let side = input[0].split("|")
        let sside = input[0].replace(" | ", "")
        cube[i] = side.map( x => x = x.trim())
        if(sside.indexOf("s") >= 0) {
            startX = sside.indexOf("s")%n;
            startY = i;
            startZ = Math.floor(sside.indexOf("s")/n);
        }
        input.shift()
    }

    let points = 0;
    let dies = false;

    for (let i = 0; i < input.length-1; i++) {
        let command = input[i].split(" ");
        let command2 = input[i+1].split(" ");
        let dest = command[0]
        let steps = Number(command2[2])
        if(dest == "up"){
            if(startZ - steps >=0){
                for (let j = 0; j < steps; j++) {
                    startZ --;
                    if(cube[startY][startZ][startX] == "a") points++;
                }
                continue;
            }
            else{
                dies = true;
                break;
            }
        }
        else if(dest == "down"){
            if(startZ + steps < n){
                for (let j = 0; j < steps; j++) {
                    startZ ++;
                    if(cube[startY][startZ][startX] == "a") points++;
                }
                continue;

            }
            else{
                dies = true;
                break;
            }
        }
        else if(dest == "forward"){
            if(startY - steps >= 0){
                for (let j = 0; j < steps; j++) {
                    startY --;
                    if(cube[startY][startZ][startX] == "a") points++;
                }
                continue;

            }
            else{
                dies = true;
                break;
            }
        }
        else if(dest == "backward"){
            if(startY + steps < n){
                for (let j = 0; j < steps; j++) {
                    startY ++;
                    if(cube[startY][startZ][startX] == "a") points++;
                }
                continue;
            }
            else{
                dies = true;
                break;
            }
        }
        else if(dest == "left"){
            if(startX - steps >= 0){
                for (let j = 0; j < steps; j++) {
                    startX --;
                    if(cube[startY][startZ][startX] == "a") points++;
                }
                continue;

            }
            else{
                dies = true;
                break;
            }
        }
        else if(dest == "right"){
            if(startX + steps < n){
                for (let j = 0; j < steps; j++) {
                    startZ ++;
                    if(cube[startY][startZ][startX] == "a") points++;
                }
                continue;

            }
            else{
                dies = true;
                break;
            }
        }
        else if(dest == "end") break;
    }

    console.log("Points collected: "+ points)
    if(dies == true)
    console.log("The snake dies.")
}

// snake(["2",
//     "so | oo",
//     "oa | ao",
//     "right",
//     "down in 1 step",
//     "end in 2 step"])

snake(["3",
    "ooo | oao | ooo",
    "osa | ooo | ooo",
    "ooo | oao | ooa",
    "forward",
    "down in 1 steps",
    "backward in 1 steps",
    "down in 2 steps",
    "right in 1 step",
    "end in 1 step"])