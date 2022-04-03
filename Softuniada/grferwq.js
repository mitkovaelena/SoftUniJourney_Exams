function trs(input){
    let [m,n] = input[0].split(" ")
    input.shift();
    let trees = [];
    for (let i = 0; i < m; i++) {
        let trsSplit = input[0].split(" ");
        trees[i]= {
            left: Number(trsSplit[0]),
            top: Number(trsSplit[1]),
            right: Number(trsSplit[2]),
            bottom: Number(trsSplit[3])
        }
        input.shift();
    }

    let sequenses = [];



    console.log( intersect(trees[1],trees[2]))
    function intersect(a, b) {
        let x_overlap = Math.max(0, Math.min(a.right,b.right) - Math.max(a.left,b.left));
        let y_overlap = Math.max(0, Math.min(a.top,b.top) - Math.max(a.bottom,b.bottom));
        return x_overlap*y_overlap
    }
}

trs(["4 3",
    "-10 30 60 10",
    "-50 20 -30 -20",
    "-35 60 -20 15",
    "4 2",
    "3 4",
    "4 1"])