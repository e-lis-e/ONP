//import React from "react";

const RegisterScreen = () => {
    return (
        <div className="container">
            <h2>Cadastre-se</h2>
            <form className="registerForm">
                <input type="text" placeholder="Nome de Usuário" required/>
                <input type="text" placeholder="E-mail" required/>
                <input type="password" placeholder="Senha" required/>
                <button type="submit">Cadastrar Perfil</button>
            </form>
        </div>
    );
};

export default RegisterScreen;