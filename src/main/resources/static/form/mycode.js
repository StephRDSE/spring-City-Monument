function SaveCity() {
	datas = $('#citiesForm').serialize()
	doPostRequest("http://192.168.43.247:8090/city",datas)
	
}


function TraiteReponse(repTexte)
{
    alert(repTexte); 
}


function doPostRequest(Url,Datas) 
{
	var request = new XMLHttpRequest();
    request.onreadystatechange = function()
    {
        if (request.readyState == 4 && request.status == 201)
        {
        		TraiteReponse(request.responseText); 
        }
    }; 
    request.open('POST', Url);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.setRequestHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
    request.setRequestHeader("Accept-Language", "fr-FR,fr;q=0.9,en;q=0.8");
        
    request.send(Datas);
}
