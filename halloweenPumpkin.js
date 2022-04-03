function haloweenP (n) {
    console.log(".".repeat(n-1) + "_/_" + ".".repeat(n-1))
    console.log("/" + ".".repeat(n-2) + "^,^" + ".".repeat(n-2) + "\\")

    for (let i = 0; i < n-3; i++) {
        console.log("|" + ".".repeat(2*n-1) + "|")
    }
    console.log("\\" + ".".repeat(n-2) + "\\_/" + ".".repeat(n-2) + "/")

}

haloweenP(["5"])