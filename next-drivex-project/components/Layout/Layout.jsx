import Footer from "../Footer/Footer";
import Header from "../Header/Header";

const Layout = ({children}) => {
    return(
        <section>
            <Header />
            {children}
            <Footer />
        </section>
    );
}

export default Layout;