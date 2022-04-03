function crossingFigures(inp){
    let input = inp[0].split("\n")
    input.shift();
    for (let i = 0; i < input.length; i+=2) {
        let circle, rectangle;
        if(input[i].indexOf("circle")>=0){
            circle = input[i];
            rectangle=input[i+1]
        }
        else{
            circle = input[i+1];
            rectangle=input[i]
        }
        circle = circle.slice(circle.indexOf("circle")+7, circle.length-1).split(", ").map(Number)
        rectangle = rectangle.slice(rectangle.indexOf("rectangle")+10, rectangle.length-1).split(", ").map(Number)

        if(circle[0]-circle[2] >= rectangle[0] &&circle[0]+circle[2] <= rectangle[2] &&
            circle[1]-circle[2] >= rectangle[3] &&circle[1]+circle[2] <= rectangle[1]){
            console.log("Circle inside rectangle");
        }
        else if(circle[0]-circle[2] < rectangle[0] &&circle[0]+circle[2] > rectangle[2] &&
            circle[1]-circle[2] < rectangle[3] &&circle[1]+circle[2] > rectangle[1]){
            console.log("Rectangle inside circle");
        }
        else if(circle[0]-circle[2] > rectangle[2] || circle[0]+circle[2] < rectangle[0] ||
            circle[1]-circle[2] > rectangle[1] || circle[1]+circle[2] < rectangle[3]){
            console.log("Rectangle and circle do not cross");
        }
            
            
        else if(circle[0]-circle[2] == rectangle[2] && (circle[1]+circle[2] < rectangle[3] || circle[1]-circle[2] > rectangle[1])){
            console.log("Rectangle and circle do not cross");
        }
        else if( circle[0]+circle[2] == rectangle[0]  && (circle[1]+circle[2] < rectangle[3] || circle[1]-circle[2] > rectangle[1])){
            console.log("Rectangle and circle do not cross");
        }
        else if( circle[1]-circle[2] == rectangle[1]  && (circle[0]+circle[2] < rectangle[0] || circle[0]-circle[2] > rectangle[2])){
            console.log("Rectangle and circle do not cross");
        }
        else if( circle[1]+circle[2] == rectangle[3]  && (circle[0]+circle[2] < rectangle[0] || circle[0]-circle[2] > rectangle[2])){
            console.log("Rectangle and circle do not cross");
        }
            
            
        else{
            console.log("Rectangle and circle cross");
        }
    }
}
