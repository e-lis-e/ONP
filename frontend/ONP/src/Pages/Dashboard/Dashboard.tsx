import './Dashboard.css';
import Header from '../../Components/Header/Header';
import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

interface Postagem {
    id: number;
    titulo: string;
    conteudo: string;
    data: string;
    postagemAdmin: boolean;
    interacoes: unknown[];
    comentarios: unknown[];
}

const Dashboard: React.FC = () => {
    const [postagens, setPostagens] = useState<Postagem[]>([]);
    const navigate = useNavigate();

    const formatDate = (data: string): string => {
        return new Date(data).toLocaleDateString('pt-BR', {
            day: '2-digit',
            month: '2-digit',
            year: 'numeric',
        });
    };

    useEffect(() => {
        fetch('http://localhost:8080/api/postagem')
            .then((res) => {
                if (!res.ok) {
                    throw new Error(`Erro ${res.status}: ${res.statusText}`);
                }
                const contentType = res.headers.get('content-type');
                if (!contentType || !contentType.includes('application/json')) {
                    console.log(res)
                    throw new Error('Resposta não é JSON');
                }
                return res.json();
            })
            .then((data: Postagem[]) => setPostagens(data))
            .catch((error) => {
                console.error('Erro ao buscar postagens:', error);
            });
    }, []);

    const handlePostagemClick = (postagemId: number) => {
        navigate(`/postagem/${postagemId}`);
    };

    return (
        <div className="dashboard">
            <div className="container">
                <Header />
                <div className="dashboardContent">
                    <div className="discussoes">
                        <h2>Discussões</h2>
                        {postagens.length > 0 ? (
                            <ul>
                                {postagens.map((postagem) => (
                                    <li
                                        key={postagem.id}
                                        onClick={() => handlePostagemClick(postagem.id)}
                                        style={{ cursor: 'pointer', color: 'white' }}
                                    >
                                        {postagem.titulo}
                                    </li>
                                ))}
                            </ul>
                        ) : (
                            <p>Nenhuma discussão encontrada</p>
                        )}
                    </div>
                    <div className="posts">
                        <h2>Postagens</h2>
                        {postagens.length > 0 ? (
                            <ul>
                                {postagens.map((postagem) => (
                                    <li
                                        key={postagem.id}
                                        onClick={() => handlePostagemClick(postagem.id)}
                                        style={{ cursor: 'pointer', color: 'white' }}
                                    >
                                        {postagem.titulo} -{' '}
                                        <span>
                                            {postagem.postagemAdmin ? 'Admin' : 'Usuário'} |{' '}
                                            {formatDate(postagem.data)}
                                        </span>
                                    </li>
                                ))}
                            </ul>
                        ) : (
                            <p>Nenhuma postagem encontrada</p>
                        )}
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Dashboard;
