function drawAhouse([n]) {
    let m=Number(n)-1
    let s = 1

    console.log(`${".".repeat(m)}*${".".repeat(m--)}`)
    for (let i = 1; i < n-1; i++) {
        console.log(`${".".repeat(m)}*${" ".repeat(s)}*${".".repeat(m--)}`)
            s+=2;
    }
    console.log(`${"* ".repeat(n)}`)
    console.log(`+${"-".repeat(2*n-3)}+`)
    for (let i = 0; i < n-2; i++) {
            console.log(`|${" ".repeat(2*n-3)}|`)
    }
    console.log(`+${"-".repeat(2*n-3)}+`)
}

drawAhouse([5])