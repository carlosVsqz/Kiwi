import {ThemeVariation} from '@common/enum';
import Loading from '@components/other/loading';
import PostTrending from '@components/post/post-trending';
import SubcribeCard, {SubcribeCardFormProps} from '@components/subcribe-card';
import {AppState} from '@store';
import React, {useEffect} from 'react';
import {useDispatch, useSelector} from 'react-redux';
import styled from 'styled-components';
import {handleArchiveCategories} from "@store/thunk/archive";
import CategoryBarArchive from "@components/category/barArchive";

const StyledPostTrending = styled(PostTrending)`
  &:not(:last-child) {
    margin-bottom: ${20 / 14}rem;
  }
`;

const ArchivesListSidebar = ({ theme }: { theme?: ThemeVariation }) => {
  const dispatch = useDispatch();

  const { data: categoriesData, fetching: categoriesFetching } = useSelector(
    (state: AppState) => state.archives.categories,
  );
  const { data: trendingData, fetching: trendingFetching } = useSelector((state: AppState) => state.archives.trendingList);

  useEffect(() => {
    // dispatch(handleGetTrendingPosts({ _limit: 5 }));
    dispatch(handleArchiveCategories({}));
  }, []);

  const onFormSubmit = (val: SubcribeCardFormProps) => {
    console.log(val);
  };

  return (
    <div className="blog-sidebar">
      <div className="blog-sidebar-section -category">
        <div className="blog-sidebar-section__title">
          <h5>Categorías</h5>
        </div>
        {categoriesFetching ? (
          <Loading theme={theme} />
        ) : (
          categoriesData?.map((item, index) => <CategoryBarArchive key={index} data={item} />)
        )}
      </div>

      <div className="blog-sidebar-section -category">
        {/*<div className="blog-sidebar-section__title">*/}
        {/*  <h5>tendencias</h5>*/}
        {/*</div>*/}
        {/*{trendingFetching ? (<Loading theme={theme} />) : (trendingData.map((post, index) => (<StyledPostTrending theme={theme} key={index} data={post} rank={index + 1} />)))}*/}
      </div>
      {/*<SubcribeCard onSubmit={onFormSubmit} theme={theme} />*/}
    </div>
  );
};

export default ArchivesListSidebar;
