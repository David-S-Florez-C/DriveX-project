import React from "react";
import Link from "next/link";

const MessageCard = (props) => {
    return(
        <React.Fragment>
            <div>
                <picture>
                    <img src = "" alt = {`Icon ${props.id}`} />
                </picture>
                <div>
                    <p>{props.text}</p>

                    <Link href={`/messages/${props.id}`}>More details</Link>
                </div>
            </div>
        </React.Fragment>
    );
};

export default MessageCard;