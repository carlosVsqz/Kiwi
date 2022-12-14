import Layout from '@components/layout';
import React from 'react';
import GUButton from '@components/control/gu-button';
import Breadcrumb, {BreadcrumbItem} from '@components/other/breadcrumb';
import Instagram from '@components/sections/instagram';

const Error = () => {
  return (
    <Layout title="Error">
      <div className="container">
        <Breadcrumb>
          <BreadcrumbItem href="/" startIcon={<i className="fas fa-home"></i>}>
            Inicio
          </BreadcrumbItem>
          <BreadcrumbItem>Error</BreadcrumbItem>
        </Breadcrumb>
        <div className="error-404">
          <div className="row align-items-center">
            <div className="col-12 col-md-6">
              <div className="error-404__content">
                <h2>404 Pagina no encontrada</h2>
                <p>Parece que no se encontró nada en este lugar. Intenta una búsqueda!!!</p>
                <form action="/">
                  <input type="text" name="keyword" placeholder="Busca por frase" />
                  <button>
                    <i className="far fa-search"></i>
                  </button>
                </form>
                <GUButton size="large" variant="contained" shape="round" href="/">
                  Regresar al inicio
                </GUButton>
              </div>
            </div>
            <div className="col-12 col-md-6">
              <div className="error-404__image">
                <img src="/assets/images/pages/404.png" alt="404 error image" />
              </div>
            </div>
          </div>
        </div>
      </div>
      <Instagram />
    </Layout>
  );
};

export default Error;
