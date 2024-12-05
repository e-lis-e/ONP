import React, { useState } from "react";
import "./PostagemModal.css";

interface PostagemModalProps {
    isOpen: boolean;
    onClose: () => void;
}

const PostagemModal: React.FC<PostagemModalProps> = ({ isOpen, onClose }) => {
    const [titulo, setTitulo] = useState<string>("");
    const [conteudo, setConteudo] = useState<string>("");

    const handlePostagemSubmit = async () => {
        const postagem = {
            usuario: 1,
            titulo,
            conteudo,
            data: new Date().toISOString(),
            postagemAdmin: false
        };

        try {
            const response = await fetch("http://localhost:8080/api/postagem", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(postagem),
            });

            if (response.ok) {
                console.log("Postagem criada com sucesso");
                onClose();
            } else {
                console.error("Erro ao criar postagem");
            }
        } catch (error) {
            console.error("Erro ao enviar postagem:", error);
        }
    };

    if (!isOpen) return null;

    return (
        <div className="postagemModal" onClick={onClose}>
            <div className="postagemModalContent" onClick={(e) => e.stopPropagation()}>
                <input
                    type="text"
                    className="postTitle"
                    placeholder="Título"
                    value={titulo}
                    onChange={(e) => setTitulo(e.target.value)}
                />
                <input
                    type="text"
                    className="postBox"
                    placeholder="Poste suas dúvidas e discussões"
                    value={conteudo}
                    onChange={(e) => setConteudo(e.target.value)}
                />
                <button className="postagemButton" onClick={handlePostagemSubmit}>Enviar</button>
            </div>
        </div>
    );
};

export default PostagemModal;
