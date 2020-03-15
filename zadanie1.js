var n = prompt("n", "");
var count = 1;
for(let i = 2; i < n; i++) {
  for(let j = 1; j <= i; j++){
    if((n % j == 0) && (i % j == 0)) {
      if(j != 1) {
        count++;
      }
    }
  }
  if(count == 1) {
    alert(i);
  }
  count = 1;
}