import Layout from '@components/layout';
import Instagram from '@components/sections/instagram';
import styled from 'styled-components';
import ToggleViewSidebarInformative from "@components/posts-layout/toggle-view-sidebarInformative";

const PostsListContainer = styled.div`
  margin-bottom: ${80 / 14}rem;
`;

const InformativeCategoryGrid = () => {
  return (
    <Layout title="Información publica | Informativo">
      <PostsListContainer>
        <ToggleViewSidebarInformative />
      </PostsListContainer>
      <Instagram />
    </Layout>
  );
};

export default InformativeCategoryGrid;
