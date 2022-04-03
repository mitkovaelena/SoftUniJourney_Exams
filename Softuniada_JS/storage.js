function storage([storages, orders]) {
    storages = storages.split(" ").map(Number)
    orders = orders.split(" ").map(Number)
    let ordersOccs = [];
    let occ = 0;
    for(let o of orders){
        if(ordersOccs[o]){
            ordersOccs[o]++;
        }
        else ordersOccs[o] = 1;
    }
    let ordersOccsSorted = [];
    for(let o in ordersOccs){
        ordersOccsSorted.push([Number(o), ordersOccs[o]])
    }

    ordersOccsSorted.sort((a,b) =>a[1]-b[1])

    if(storages.indexOf(orders[0])<0){
        console.log("impossible")
        return;
    }
    let swaps1 = 0;
    let swaps2 = 0;

    for(let order of orders){
        if(storages.indexOf(order)<0){
            swaps2++;
        }
    }

    for(let order of orders){
        if(storages.indexOf(order)<0){
            for(let j = 0; j<ordersOccsSorted.length; j++){
                if(storages.indexOf(ordersOccsSorted[j][0])>=0){
                    let ind = storages.indexOf(Number(ordersOccsSorted[j][0]))
                    storages[ind]= order;
                    swaps1++;
                    break;
                }
            }
        }
    }
    console.log(Math.min(swaps1,swaps2))
}
storage(["5 6 7 8",
    "5 3 6 6 7"])