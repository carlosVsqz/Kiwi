import MasonryRandom from "@components/posts-layout/masonry-random";
import {useDispatch, useSelector} from "react-redux";
import {AppState} from "@store";
import {handleGetPosts} from "@store/thunk/post";
import React, {useEffect} from "react";
import styled from 'styled-components';
import MainPostInline from "@components/post/main-post-inline";
import HeaderTitleLine from "@components/other/header-title-line";
import {ThemeVariation} from "@common/enum";

const PostsContainer = styled.div``;

const CategoryDescContainer = styled.div`
  font-weight: 700;
  font-size: 48px;
`;

const Homepage = () => {

  const PAGE_SIZE = 4;
  const dispatch = useDispatch();

  const {data, fetching, meta, loadingMore} = useSelector((state: AppState) => state.posts.list);

  const itemResponseState = useSelector((state:AppState) => state.posts.main)
  useEffect(() => {
    dispatch(handleGetPosts({_limit: PAGE_SIZE}));
  }, []);

  const onLoadingMore = () => {
    if (meta && data.length && meta.page < meta.pageCount) {
      dispatch(handleGetPosts({_limit: PAGE_SIZE, _page: meta.page + 1, loadingMore: true}));
    }
  };
  const THEME = ThemeVariation.Third;
  return (
    <>
      <div className="container">
        <PostsContainer>
          {!!data.length && <MainPostInline data={data[0]} className="-banner"/>}
        </PostsContainer>
      </div>
      <div className="container">
        <HeaderTitleLine className=" col-12 col-md-12" title="Categorias"/>

        <CategoryDescContainer className="center">
          <h2 className="mb-3">
            Encarga trabajo en más de {data.length} publicaciones distintas
          </h2>
        </CategoryDescContainer>

      </div>
      {/*<Instagram theme={THEME}/>*/}
      <MasonryRandom/>
    </>
  );
}

export default Homepage;