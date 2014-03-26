
function validateSoloNumeros(event){
    var respuesta = false
    var controlKeys = [8, 9, 13];
    var isControlKey = controlKeys.join(",").match(new RegExp(event.which));
    if (!event.which || // Control keys in most browsers. e.g. Firefox tab is 0
      (48 <= event.which && event.which <= 57) || // Always 1 through 9
      isControlKey) { // Opera assigns values for control keys.
        respuesta = true;
      }
     return respuesta;
}
