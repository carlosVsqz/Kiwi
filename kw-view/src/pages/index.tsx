import Layout from '@components/layout';
import jsx from '../i18n/properties';
import Homepage from "@pages/homepage/homepage";

const Home = () => {
  return (
    <Layout title={jsx.content}>
      <Homepage/>
    </Layout>
  );
};

export default Home;
