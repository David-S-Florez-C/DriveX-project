import React, { useState } from "react";
import { useRouter } from "next/router";
import DeleteMessage from "../../components/CRUD/Messages/DeleteMessage";
import PutMessage from "../../components/CRUD/Messages/PutMessage";

export default function MessageItem() {
    const [message, setMessage] = useState([]);
    
    const { query: { messageId }, } = useRouter();

    async function fetchData() {
        try {
            const response = await fetch(`https://g4932924a17736e-ca5bxc3sr3p4rtcw.adb.us-chicago-1.oraclecloudapps.com/ords/admin/message/message/${messageId}`)
            const data = await response.json();
            setMessage(data.items);
        } catch(error) {
            console.log(error);
        }
    }

    fetchData();
    

    return(
        <React.Fragment>
            <section>
                <h1>This is the message: {messageId}</h1>
                {message?.map((message) => (
                    <div key = {message.message_id}>
                        <picture>
                            <img src = "" alt = {`Icon ${message.message_id}`} />
                        </picture>
                        <div>
                            <p>{message.message_text}</p>
                        </div>
                    </div>
                ))}
                <DeleteMessage messageId={messageId}/>
                <PutMessage />
            </section>
        </React.Fragment>
    );
};