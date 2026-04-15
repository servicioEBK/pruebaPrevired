document.getElementById("btnListar").addEventListener("click", function () {
	document.getElementById("resultado").textContent = "";
	document.getElementById("formularioBox").hidden = true;
	document.getElementById("eliminarPe").hidden = true;

	fetch("/api/getRegistro")
	  .then(response => response.json())
	  .then(data => {
	    const elemento = document.getElementById("resultado");
	    elemento.textContent = JSON.stringify(data, null, 2);
	  })
	.catch(error => {
    		document.getElementById("resultado").textContent = error.message;
    	});
});

document.getElementById("btnAgregar").addEventListener("click", function () {
	document.getElementById("resultado").textContent = "";
    document.getElementById("formularioBox").hidden = false;
    document.getElementById("eliminarPe").hidden = true;
});   

document.getElementById("btnBorrar").addEventListener("click", function () {
	document.getElementById("resultado").textContent = "";
	document.getElementById("formularioBox").hidden = true;
    document.getElementById("eliminarPe").hidden = false;
});


document.getElementById("formGuardar").addEventListener("submit", function(e) {
	e.preventDefault();
	document.getElementById("resultado").textContent = "";
	const salario = document.getElementById("salario").value;
    if (salario < 400000) {
        document.getElementById("resultado").textContent = "Debe ser salario mayor a $400.000";
        return;
    } 
    
    const rut = document.getElementById("rut_dni");
    const regex = /^[0-9]+-[0-9kK]{1}$/;
    if (!regex.test(rut.value)) {
  	  document.getElementById("resultado").textContent = "Formato incorrecto rut_dni";
  	 return;
    }

    fetch("/api/getAddRegistro", {
    	  method: "POST",
    	  body: new FormData(this)
    	})
    	.then(response => response.json())
    	.then(data => {
    	  console.log(data);
    	  document.getElementById("resultado").textContent = JSON.stringify(data, null, 2);
    	})
    	.catch(error => {
    	  console.error(error);
    	});
    /**/
    
	  
	});


document.getElementById("btnEliminar").addEventListener("click", function () {
	document.getElementById("resultado").textContent = "";
    const id = document.getElementById("idPersona").value;
    if (!id) {
        document.getElementById("resultado").textContent = "Debe ingresar un ID";
        return;
    }
    
    fetch("/api/getDelRegistro/" + id, {
        method: "DELETE"
    })
    .then(async response => {
        const texto = await response.text();

        if (!response.ok) {
            throw new Error("Error " + response.status + ": " + texto);
        }

        return texto;
    })
    .then(data => {
        document.getElementById("resultado").textContent = data;
    })
    .catch(error => {
        document.getElementById("resultado").textContent = error.message;
    });

});

 

