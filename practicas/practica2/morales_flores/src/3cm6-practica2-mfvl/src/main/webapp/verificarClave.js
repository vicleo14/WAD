function comprobarClave(){
    clave1 = document.form1.pswd.value;
    clave2 = document.form1.rpswd.value;

    if (clave1 == clave2){
    	document.form1.submit();
    }
    else
       alert("Las dos claves son distintas");
} 