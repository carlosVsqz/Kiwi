import Layout from '@components/layout';
import Instagram from '@components/sections/instagram';
import styled from 'styled-components';
import ToggleViewSidebarGeneral from "@components/posts-layout/toggle-view-sidebarGeneral";

const PostsListContainer = styled.div`
  margin-bottom: ${80 / 14}rem;
`;

const GeneralCategoryGrid = () => {
  return (
    <Layout title="Información publica | General">
      <PostsListContainer>
        <ToggleViewSidebarGeneral />
      </PostsListContainer>
      <Instagram />
    </Layout>
  );
};

export default GeneralCategoryGrid;
