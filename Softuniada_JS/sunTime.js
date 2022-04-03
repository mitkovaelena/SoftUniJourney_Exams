function sunTime(input){
    [input1, input2] = input[0].split("\n")
    input1 = input1.split(":").map(Number);
    input2 = input2.split(":").map(Number);
    let days,hours,mins;
    if(input1.length == 4){
        days = input1[0];
        hours= input1[2];
        mins = input1[3];
    }
    else{
        days = 0;
        hours= input1[0];
        mins = input1[1];
    }

    if(input2.length == 4){
        days += input2[0];
        hours += input2[2];
        mins += input2[3];
    }
    else{
        hours += input2[0];
        mins += input2[1];
    }

    if(mins >= 60){
        hours += Math.floor(mins/60)
        mins %= 60;
    }
    if(hours >= 24){
        days += Math.floor(hours/24)
        hours %= 24;
    }
    if(mins < 10) mins = "0"+mins;

    if(days>0)
    console.log(`${days}::${hours}:${mins}`)
    else
        console.log(`${hours}:${mins}`)
}

sunTime(["3::12:30\n12:31"])