
$(function() {

    $h = $('#hidenAcceso');
    $p = $('#msgError');
    n = parseInt($h.val());
    
    if (n == 1) {
        $p.attr('class','error');
        $h.val(1);
    }

});

