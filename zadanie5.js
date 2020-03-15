var n = prompt("n", "");
let arr = new Array();
var sum = 1;
for(let i = 0; i < n; i++) {
  arr[i] = prompt("arr[" + i + "]", "");
}
for(let j = 1; j <= n; j++) {
  sum = sum * (Math.pow((-1), (j + 1)) * arr[j - 1]);
  alert(sum);
}