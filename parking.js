function parking(input) {
    let n = input[0]
    input.shift();
    let zones = [];
    for (let i = 0; i < n; i++) {
        let zone = input[0].split(" ")
        zones[i] = {
            name:zone[0].slice(0,zone[0].length-1),
            x:Number(zone[1].slice(0,zone[1].length-1)),
            y:Number(zone[2].slice(0,zone[2].length-1)),
            len:Number(zone[3].slice(0,zone[3].length-1)),
            wid:Number(zone[4].slice(0,zone[4].length-1)),
            price:Number(zone[5])
        }
        input.shift();
    }
    let places = input[0].split("; ");
    let home = input[1].split(", ").map(Number);
    let k = Number(input[2])/60
    let placesPriceTime = {
        price:10000,
        dist:10000

    };

    for(let i=0; i < places.length; i++){
        let plc = places[i].split(", ")
        let dist =  (Math.abs(home[0]-plc[0])+ Math.abs(home[1]-plc[1])-1)*2
        let zoneType;
        let zoneTypePrice;
        for(let z of zones){
            if(z.x <= plc[0] && z.x+z.len>=plc[0] && z.y <= plc[1] && z.y+z.wid>=plc[1]){
                zoneType = z.name;
                zoneTypePrice = z.price;
                break;
            }
        }
        let price = Math.ceil(k*dist)*zoneTypePrice
        if (placesPriceTime.price >= price) {
            if(placesPriceTime.dist < dist) continue;
                placesPriceTime = {
                    zoneType: zoneType,
                    x: plc[0],
                    y: plc[1],
                    dist: dist,
                    price: price
                }
        }
    }
    console.log(`Zone Type: ${placesPriceTime.zoneType}; X: ${placesPriceTime.x}; Y: ${placesPriceTime.y}; Price: ${parseFloat(Math.round(placesPriceTime.price * 100) / 100).toFixed(2)}`)
}

parking(["2",
    "Blue: 0, 0, 10, 10, 1.0",
"Green: 0, 10, 10, 10, 0.5",
"1, 1; 5, 5; 1, 11; 5, 16",
"15, 10",
"20"])