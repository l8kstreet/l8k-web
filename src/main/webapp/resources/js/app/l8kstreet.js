
var app = (function() {
    var BASE_URI = baseURI();

    /** Returns the base URI for the application.
     */
    function baseURI() {
        if (document.baseURI) {
            return document.baseURI;
        }
        //IE does not support document.baseURI...
        var base = document.getElementsByTagName('base');
        if (base && base[0] && base[0].href) {
            return base[0].href;
        }
        //no base found in document, use relative URIs
        return "";
    }

    return {
        baseURI: BASE_URI
    };
})();