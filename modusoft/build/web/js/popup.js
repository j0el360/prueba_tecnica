var btnAbrirPopup = document.getElementById('btn-abrir-popup'),
        btnAbrirPopupCancelar = document.getElementById('btn-abrir-popup-cancelar'),
	overlay_confirmar = document.getElementById('overlay-confirmar'),
	popup_confirmar = document.getElementById('popup-confirmar'),
        overlay_cancelar = document.getElementById('overlay-cancelar'),
	popup_cancelar = document.getElementById('popup-cancelar'),
	btnCerrarPopup = document.getElementById('btn-cerrar-popup');

btnAbrirPopup.addEventListener('click', function(){
	overlay_confirmar.classList.add('active');
	popup_confirmar.classList.add('active');        
});

btnCerrarPopup.addEventListener('click', function(e){
	e.preventDefault();
	overlay_confirmar.classList.remove('active');
	popup_confirmar.classList.remove('active');
});

btnAbrirPopupCancelar.addEventListener('click', function(){
	overlay_cancelar.classList.add('active');
	popup_cancelar.classList.add('active');        
});

btnCerrarPopup.addEventListener('click', function(e){
	e.preventDefault();
	overlay_cancelar.classList.remove('active');
	popup_cancelar.classList.remove('active');
});