function starsInTheCube(inp){
    let input= inp[0].split("\n")
let n = Number(input.shift())

    let letters = [];
    let starsCount = 0;
    let sortedLetters =[];

    for (let i = 0; i < n; i++) {
     let side = input[i].split("|")
        input[i] = side.map( x => x = x.split(" ").filter(x =>x != ""))
    }

    for (let a = 1; a < n-1; a++) {
        for (let b = 1; b < n-1; b++) {
            for (let c = 1; c < n-1; c++) {
                if(input[a][b][c]==input[a][b][c-1] && input[a][b][c]==input[a][b][c+1] &&
                    input[a][b][c]==input[a-1][b][c] && input[a][b][c]==input[a+1][b][c] &&
                    input[a][b][c]==input[a][b-1][c] && input[a][b][c]==input[a][b+1][c]){
                    if(letters.hasOwnProperty(input[a][b][c])){
                        letters[input[a][b][c]] =  letters[input[a][b][c]]+1;
                        starsCount++;
                    }
                    else {
                        letters[input[a][b][c]] = 1;
                        sortedLetters.push(input[a][b][c]);
                        starsCount++;
                    }
                }
                else if(input[a][b][c]!=input[a][b][c+1]){
                   c++;
                }
            }
        }
    }


    console.log(starsCount)

    sortedLetters.sort();
    for (let letter of sortedLetters) {
        console.log(letter + " -> " + letters[letter])
    }

}

starsInTheCube(["5",
"a a a a a | a p a a a | a a a a a | a p a a a | p p p p p",
"a p a a a | p p p a a | a p a a a | p p p a a | p p p p p",
"a a a a a | a p x x a | a p a a a | p p p z a | p p p p p",
"a a x x a | a x x x x | a a x x a | a p z z z | p p p z p",
"a a a a a | a a x x a | a a a a a | a a a z a | p p p p p"])