let x = 5,    // позиция по х
    y = 4,    // позиция по у
    ka = 1.732, // коэффициент ОА
    k = 1,    // коэфиициент прямой движения
    dx = -0.1,    // шаг по оси х
    dy = -0.1;    // шаг по оси у
    while(true) {
        if(y <= 0) { // столкновение с нижней гранью
            if(x < 5) {
                y = 0;
                console.log('[ bottom bump ] x: ' + x + ' y: ' + y);
            }
            dy = - dy;
            k  = -k;
            console.log('[ directions ] dx ' + dx + ' dy ' + dy );
        }
        if(y >= ka * x) { // столкновение с боковой гранью
            if(x < 5) {
                console.log('[ side bump ] x: ' + x + ' y: ' + y);
            }
            let angle = newAngle(k, ka);
                angle = 90 - angle;
                console.log('[ new angle ] ' + angle);     
                if(angle < 45) {
                    dx = -dx;
                    dy = -dx;
                    if(dy < 0) {
                        k = Math.tan((angle + 30) * Math.PI / 180);
                    } else {
                        k = Math.tan((30 - angle) * Math.PI / 180);
                    }
                    dy *= k;
                } else {
                    dx = -dx;
                    dy = -dx;
                    if(dy < 0) {
                        k = Math.tan((angle + 30) * Math.PI / 180);
                    } else {
                        k = Math.tan((30 - angle) * Math.PI / 180);
                    }
                    dy *= k;
                }
                console.log('[ directions ] dx ' + dx + ' dy ' + dy );
        }
        if(x > 10 || y > 10 || x < 0 || y < 0) { // выход за пределы поля
            break;
        }
        x += dx;
        y += dy;
    }
    function newAngle(k1, k2) {
    return Math.round(Math.atan(Math.abs((k1 - k2) / (k1 * k2 + 1))) * 180 / Math.PI);
}