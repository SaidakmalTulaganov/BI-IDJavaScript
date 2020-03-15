let
    t_arr = [[11, 24, 7, 20, 3],

        [4, 12, 25, 8, 16],
        
        [17, 5, 13, 21, 9],
        
        [10,18, 1, 14, 22],
        
        [23, 6, 19, 2, 15]],

    f_arr = [[1,2,3,4,5],
             [6,7,8,9,10],
             [11,12,13,14,15],
             [16,17,18,19,20],
             [21,22,23,24,25]];

fn(t_arr);
fn(f_arr);

function fn(arg){
    let
        sums = [0,0,0,0,0,0,0,0,0,0,0,0];

    for(let i = 0; i < 5; i++){
        for(let j = 0; j < 5; j++){
            sums[j] += arg[i][j];
        }
    }

    for(let i = 0; i < 5; i++){
        for(let j = 0; j < 5; j++){
            sums[j+5] += arg[j][i];
        }
    }

    for(let i = 0; i < 5; i++){
        sums[10] += arg[i][i];
    }

    for(let i = 0, j = 4; i < 5, j >= 0 ; i++, j--){
        sums[11] += arg[i][j];
    }

    for(let i = 1; i < 12; i++){
        if(sums[0]!=sums[i]){
            console.log('fail');
            return;      
        }
    }

    console.log('great'); 
}
