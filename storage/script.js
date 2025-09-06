const dogImage = document.getElementById('dog-image');
const loadButton = document.getElementById('load-dog');

function carregarImagemDog() {
  fetch('https://dog.ceo/api/breeds/image/random')
    .then(response => {
      if (!response.ok) {
        throw new Error('Erro ao buscar a imagem.');
      }
      return response.json();
    })
    .then(data => {
      dogImage.src = data.message;
    })
    .catch(error => {
      alert('Erro: ' + error.message);
    });
}

window.addEventListener('DOMContentLoaded', carregarImagemDog);

loadButton.addEventListener('click', carregarImagemDog);