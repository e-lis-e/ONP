//import React from 'react';

import Header from "../../Components/Header/Header";

const Perfil = () => {
    return (
        <div>
            <Header/>
            <div className="container">
                <h2>Editar Perfil</h2>
                <form className="perfilEdit">
                <input type="text" placeholder="Nome de Usuário" required />
                <input type="text" placeholder="E-mail" required />
                <input type="password" placeholder="Nova Senha" />
                <button type="submit">Salvar Alterações</button>
                </form>
            </div>
        </div>
    );
};

export default Perfil;