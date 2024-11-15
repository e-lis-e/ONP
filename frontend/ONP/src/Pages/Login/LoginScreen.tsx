//import React from "react";

const LoginScreen = () => {
    return (
        <div className="container">
            <h2>Acesse seu perfil no DCyber</h2>
            <form className="loginForm">
                <input type="text" placeholder="E-mail" required/>
                <input type="password" placeholder="Senha" required/>
                <button type="submit">Entrar</button>
            </form>
        </div>
    );
};

export default LoginScreen;