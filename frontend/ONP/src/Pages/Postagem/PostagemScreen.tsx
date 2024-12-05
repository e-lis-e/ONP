import { useParams, Link } from 'react-router-dom';
import { useEffect, useState } from 'react';
import './PostagemScreen.css';

interface Postagem {
    postagem_id: number;
    titulo: string;
    conteudo: string;
    usuario?: {
        nome: string;
    };
}

const PostagemScreen: React.FC = () => {
    const { postagem_id } = useParams<{ postagem_id: string }>();
    const [postagem, setPostagem] = useState<Postagem | null>(null);

    useEffect(() => {
        fetch(`/api/postagem/${postagem_id}`)
            .then((res) => {
                if (!res.ok) {
                    throw new Error("Erro ao buscar a postagem");
                }
                return res.json();
            })
            .then((data: Postagem) => setPostagem(data))
            .catch((error) => console.error('Erro ao buscar a postagem:', error));
    }, [postagem_id]);

    if (!postagem) {
        return <p>Carregando postagem...</p>;
    }

    return (
        <div className="postagem">
            <div className="container">
                <div className="postagemContent">
                    <h1>{postagem.titulo}</h1>
                    <p>{postagem.conteudo}</p>
                    {postagem.usuario && <p className="autor">Autor: {postagem.usuario.nome}</p>}
                    <Link to="/">Voltar para Dashboard</Link>
                </div>
            </div>
        </div>
    );
};

export default PostagemScreen;
