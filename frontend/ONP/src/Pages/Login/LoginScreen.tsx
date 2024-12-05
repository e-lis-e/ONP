import { Link, useNavigate } from 'react-router-dom';
import { useState } from 'react';
import api from '../../services/api';
import '../LoginRegister.css';
import { AxiosError } from 'axios';

const LoginScreen = () => {
    const [formData, setFormData] = useState({
        email: '',
        senha: ''
    });
    const [error, setError] = useState('');
    const navigate = useNavigate();

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };

    const handleLogin = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            const response = await api.post('/auth/login', formData);
            localStorage.setItem('token', response.data.token); 
            navigate('/');
        } catch (err: unknown) {
            if (err instanceof AxiosError) {
                setError(err.response?.data?.message || 'Erro ao fazer login.');
            } else {
                setError('Erro ao autenticar usuário.');
            }
        }
    };

    return (
        <div className="page">
            <div className="containerUser">
                <h2>Acesse seu perfil no DCyber</h2>
                {error && <p className="error">{error}</p>}
                <form onSubmit={handleLogin}>
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
                    <button type="submit">Entrar</button>
                </form>
                <Link to="/Register" className="link">Novo usuário?</Link>
            </div>
        </div>
    );
};

export default LoginScreen;
