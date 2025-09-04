function buscarProfessores(){

    var url = "/professor";

    fetch(url)
    .then((response) => response.json())
    .then((data) => {
        let div = document.querySelector('.professor');
        data.forEach(porfessor => {
            div.innerHTML += `
                <tr>
                        <th scope="row">${porfessor.id}</th>
                        <td>${porfessor.nome}</td>
                        <td>${porfessor.profissao}</td>
                <tr>
            `;
            console.log(porfessor.nome + " tem a profissão: "+ porfessor.profissao);
        });
    })
    .catch((error) => {
        console.error(error)
    })
}