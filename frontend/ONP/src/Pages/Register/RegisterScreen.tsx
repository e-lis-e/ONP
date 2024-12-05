import { Link, useNavigate } from 'react-router-dom';
import { useState } from 'react';
import api from '../../services/api';
import '../LoginRegister.css';
import { AxiosError } from 'axios';

const RegisterScreen = () => {
    const [formData, setFormData] = useState({
        nomeDeUsuario: '',
        email: '',
        senha: '',
        fotoDePerfil: null
    });
    const [error, setError] = useState('');
    const navigate = useNavigate();

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };

    const handleRegister = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            await api.post('auth/register', formData);
            navigate('/login');
        } catch (err: unknown) {
            if (err instanceof AxiosError) {
                setError(err.response?.data?.message || 'Erro ao registrar usuário.');
            } else {
                setError('Erro ao registrar usuário.');
            }
        }
    };

    return (
        <div className="page">
            <div className="containerUser">
                <h2>Cadastre-se</h2>
                {error && <p className="error">{error}</p>}
                <form onSubmit={handleRegister}>
                    <input
                        type="text"
                        name="nomeDeUsuario"
                        placeholder="Nome de Usuário"
                        value={formData.nomeDeUsuario}
                        onChange={handleChange}
                        required
                    />
                    <input
                        type="email"
                        name="email"
                        placeholder="E-mail"
                        value={formData.email}
                        onChange={handleChange}
                        required
                    />
                    <input
                        type="password"
                        name="senha"
                        placeholder="Senha"
                        value={formData.senha}
                        onChange={handleChange}
                        required
                    />
                    <button type="submit">Cadastrar Perfil</button>
                </form>
                <Link to="/Login" className="link">Já possui conta?</Link>
            </div>
        </div>
    );
};

export default RegisterScreen;
