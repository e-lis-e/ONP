//import React from "react";
import './Dashboard.css';
import Header from '../../Components/Header/Header';
import { useEffect, useState } from 'react';

interface Postagem {
    postagem_id: number;
    titulo: string;
    usuario?: {
        nome: string;
    };
}
const Dashboard: React.FC  = () => {
    const [postagens, setPostagens] = useState<Postagem[]>([]);

    useEffect(() => {
        fetch('/api/postagem')
        .then((res) => {
            if (!res.ok) {
                throw new Error("Erro ao buscar postagens");
            }
            return res.json();
        })
        .then((data: Postagem[]) => setPostagens(data))
        .catch((error) => console.error('Erro ao buscar postagens:', error));
    }, []);

    return (
        <div className='dashboard'>
            <div className="container">
            <Header />
                <div className="dashboardContent">
                    <div className="discussoes">
                        <h2>Discussões</h2>
                         {postagens.length > 0 ? (
                            <ul>
                                {postagens.map((postagem) => (
                                    <li key={postagem.postagem_id}>{postagem.titulo}</li>
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
                                    <li key={postagem.postagem_id}>{postagem.titulo} - <span>{postagem.usuario?.nome}</span></li>
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

export default Dashboard