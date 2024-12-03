import { Link } from 'react-router-dom';
import '../LoginRegister.css';

const RegisterScreen = () => {
    return (
        <div className="page">
            <div className="containerUser">
                <h2>Cadastre-se</h2>
                <form>
                    <input type="text" placeholder="Nome de Usuário" required />
                    <input type="email" placeholder="E-mail" required />
                    <input type="password" placeholder="Senha" required />
                    <button type="submit" 
                    //onClick={handleRegister}
                    >Cadastrar Perfil</button>
                </form>
                <Link to="/Login" className='link'>Já possui conta?</Link>
            </div>
        </div>
    );
};

export default RegisterScreen;
