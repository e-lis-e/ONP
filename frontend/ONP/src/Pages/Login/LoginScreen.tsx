import { Link } from 'react-router-dom';
import '../LoginRegister.css';

const LoginScreen = () => {
    return (
        <div className="page">
            <div className="containerUser">
                <h2>Acesse seu perfil no DCyber</h2>
                <form>
                    <input type="email" placeholder="E-mail" required />
                    <input type="password" placeholder="Senha" required />
                    <button type="submit" 
                    //onClick={handleLogin}
                    >Entrar</button>
                </form>
                <Link to="/Register" className='link'>Novo usuário?</Link>
            </div>
        </div>
    );
};

export default LoginScreen;
