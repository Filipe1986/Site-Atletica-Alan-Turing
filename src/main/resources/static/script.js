//[DIRETORIA] Fotos
jQuery(document).ready(function() {
    $(".fotoDiretoria").hover(

    function() {

        $(this).find(".legendaDiretoria").animate({
        	opacity: "show",
            bottom: 0
        }, "fast");

    },

    function() {

        $(this).find(".legendaDiretoria").animate({
            opacity: "hide",
            bottom: -50
        }, "fast");
    });
});