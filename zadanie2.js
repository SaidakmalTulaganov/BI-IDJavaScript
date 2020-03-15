let array = new Array();
var arr = new Array();
for(let i = 0; i < 8; i++) {
  array[i] = prompt("array[" + i + "]", "");
}
for(var i = 0; i < 8; i++) {
    arr[i] = new Array();
    for(var j = 0; j < 8; j++){
      arr[i][j] = Math.pow(array[j], i);
    }
}
for(let i = 0; i < 8; i++) {
  for(let j = 0; j < 8; j++) {
    console.log(arr[i][j]);
  }
  console.log(" ");
}