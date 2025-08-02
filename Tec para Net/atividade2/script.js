function buscarCEP() {
  const cep = document.getElementById('cep').value.replace(/\D/g, '');
  const resultado = document.getElementById('resultado');

  resultado.innerHTML = '';

  if (!cep || cep.length !== 8) {
    resultado.innerHTML = '<p>❌ Por favor, digite um CEP válido com 8 dígitos.</p>';
    return;
  }

  fetch(`https://viacep.com.br/ws/${cep}/json/`)
    .then(response => {
      if (!response.ok) {
        throw new Error('Erro ao consultar o CEP.');
      }
      return response.json();
    })
    .then(data => {
      if (data.erro) {
        resultado.innerHTML = '<p>❌ CEP não encontrado.</p>';
      } else {
        resultado.innerHTML = `
          <p><strong>CEP:</strong> ${data.cep}</p>
          <p><strong>Logradouro:</strong> ${data.logradouro}</p>
          <p><strong>Complemento:</strong> ${data.complemento || '---'}</p>
          <p><strong>Unidade:</strong> ${data.unidade || '---'}</p>
          <p><strong>Bairro:</strong> ${data.bairro}</p>
          <p><strong>Localidade:</strong> ${data.localidade}</p>
          <p><strong>UF:</strong> ${data.uf}</p>
          <p><strong>DDD:</strong> ${data.ddd}</p>
        `;
        resultado.innerHTML += `<p style="font-style: italic;">⚠️ Estado e região não disponíveis nesta API.</p>`;
      }
    })
    .catch(error => {
      resultado.innerHTML = `<p>Erro: ${error.message}</p>`;
    });
}