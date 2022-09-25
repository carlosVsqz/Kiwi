import Layout from '@components/layout';
import Instagram from '@components/sections/instagram';
import styled from 'styled-components';
import ToggleViewSidebarArchive from "@components/posts-layout/toggle-view-sidebar-archive";

const PostsListContainer = styled.div`margin-bottom: ${80 / 14}rem;`;

const FileCategoryGrid = () => {
  return (
    <Layout title="Información publica | Archivo">
      <PostsListContainer>
        <ToggleViewSidebarArchive />
      </PostsListContainer>
      <Instagram />
    </Layout>
  );
};

export default FileCategoryGrid;
