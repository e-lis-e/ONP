import React from "react";
import "./PostagemModal.css";

interface PostagemModalProps {
    isOpen: boolean;
    onClose: () => void;
}

const PostagemModal: React.FC<PostagemModalProps> = ({ isOpen, onClose }) => {

    if (!isOpen) return null;

    return (
        <div className="postagemModal" onClick={onClose}>
            <div className="postagemModalContent" onClick={(e) => e.stopPropagation()}>
               <input type="text" className="postBox" placeholder="Poste suas dúvidas e discussões" color="333"/>
               <button className="postagemButton"> Enviar </button>
            </div>
        </div>
    );
};

export default PostagemModal;
