import {getPostCategories, getPostDetail, getPosts} from '@services/post';
import {GetPostCategoriesParams, GetPostListParams, postActions} from '@store/slices/posts';
import {Dispatch} from 'redux';

export const handleGetPosts = (param: GetPostListParams) => async (dispatch: Dispatch) => {
  try {
    dispatch(postActions.getPostsListRequest(param));
    const data = await getPosts(param);
    dispatch(postActions.getPostsListSuccess(data));
  } catch (error) {
    // @ts-ignore
    dispatch(postActions.getPostsListFailed(error.message));
  }
};

export const handleFooterPosts = (param: GetPostListParams) => async (dispatch: Dispatch) => {
  try {
    dispatch(postActions.getFooterPostsRequest(param));
    const data = await getPosts(param);
    dispatch(postActions.getFooterPostsSuccess(data));
  } catch (error) {
    // @ts-ignore
    dispatch(postActions.getFooterPostsFailed(error.message));
  }
};

export const handleGetPostDetail = (id: number) => async (dispatch: Dispatch) => {
  try {
    dispatch(postActions.getPostDetailRequest());
    const { data } = await getPostDetail(id);
    dispatch(postActions.getPostDetailSuccess(data));
  } catch (error) {
    // @ts-ignore
    dispatch(postActions.getPostsListFailed(error.message));
  }
};

export const handlePostCategories = (param?: GetPostCategoriesParams) => async (dispatch: Dispatch) => {
  try {
    dispatch(postActions.getPostCategoriesRequest());
    const data = await getPostCategories(param);
    dispatch(postActions.getPostCategoriesSuccess(data));
  } catch (error) {
    // @ts-ignore
    dispatch(postActions.getPostCategoriesFailed(error.message));
  }
};

export const handleGetTrendingPosts = (param: GetPostListParams) => async (dispatch: Dispatch) => {
  try {
    dispatch(postActions.getTrendingPostsRequest());
    const data = await getPosts({ ...param, isTrending_like: true });
    dispatch(postActions.getTrendingPostsSuccess(data));
  } catch (error) {
    // @ts-ignore
    dispatch(postActions.getTrendingPostsFailed(error.message));
  }
};

export const handleGetDestinationPosts = (param: GetPostListParams) => async (dispatch: Dispatch) => {
  try {
    dispatch(postActions.getDestinationPostsRequest());
    const data = await getPosts(param);
    dispatch(postActions.getDestinationPostsSuccess(data));
  } catch (error) {
    // @ts-ignore
    dispatch(postActions.getDestinationPostsFailed(error.message));
  }
};

export const handleGetGuidePosts = (param: GetPostListParams) => async (dispatch: Dispatch) => {
  try {
    dispatch(postActions.getGuidePostsRequest());
    const data = await getPosts(param);
    dispatch(postActions.getGuidePostsSuccess(data));
  } catch (error) {
    // @ts-ignore
    dispatch(postActions.getGuidePostsFailed(error.message));
  }
};

export const handleGetLastestPosts = (param: GetPostListParams) => async (dispatch: Dispatch) => {
  try {
    dispatch(postActions.getLastestPostsRequest());
    const data = await getPosts(param);
    dispatch(postActions.getLastestPostsSuccess(data));
  } catch (error) {
    // @ts-ignore
    dispatch(postActions.getLastestPostsFailed(error.message));
  }
};

export const handleGetRelatedPosts = (param: GetPostListParams) => async (dispatch: Dispatch) => {
  try {
    dispatch(postActions.getRelatedPostsRequest());
    const data = await getPosts(param);
    dispatch(postActions.getRelatedPostsSuccess(data));
  } catch (error) {
    // @ts-ignore
    dispatch(postActions.getRelatedtPostsFailed(error.message));
  }
};
