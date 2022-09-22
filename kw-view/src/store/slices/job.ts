import {CaseReducer, createSlice, PayloadAction} from '@reduxjs/toolkit';
import {QueryParams, ResponseState, ResponseStateDetail} from '@store/shared';
import {AuthorItem} from './author';

export enum JobCoverType {
  IMAGE = 'image',
  AUDIO = 'audio',
  VIDEO = 'video',
  SLIDE = 'slide',
  SPLIT = 'split',
}

export interface UserItem {
  id?: number;
  name: string;
  avatar: string | null;
}

export interface JobCommentItem {
  id: 1;
  publicDate: Date;
  favourite: number;
  shared: number;
  content: string;
  user: UserItem;
  replies: Omit<JobCommentItem, 'replies'>[];
}

export interface JobTagItem {
  id: number;
  name: string;
}

export interface JobItem {
  id?: number;
  image?: string | string[];
  category: JobItemCategory;
  title?: string;
  publicDate?: Date;
  commentsCount?: number;
  quote?: string;
  author?: string;
  audio?: string;
  video?: string;
  description?: string;
  type?: JobCoverType;
  comments?: JobCommentItem[];
  tags?: JobTagItem[];
  user: AuthorItem;
  content?: string;
}

export interface JobItemCategory {
  id: number;
  image: string;
  name: string;
  key: string;
  quantity: number;
}

export enum JobCategoriesType {
  Bar = 'bar',
}

export interface GetJobCategoriesParams extends QueryParams {
}

export interface GetJobListParams extends QueryParams {
  type_like?: string;
  isTrending_like?: boolean;
  'category.id_like'?: number | string | null;
}

export interface GetJobListMaronryParams extends GetJobListParams {
  isWide?: boolean;
}

interface JobState {
  list: ResponseState<JobItem>;
  related: ResponseState<JobItem>;
  destination: ResponseState<JobItem>;
  guide: ResponseState<JobItem>;
  lastest: ResponseState<JobItem>;
  trendingList: ResponseState<JobItem>;
  detail: ResponseStateDetail<JobItem>;
  footerList: ResponseState<JobItem>;
  categories: ResponseState<JobItemCategory>;
}

const initialState: JobState = {
  list: {fetching: false, data: []},
  related: {fetching: false, data: []},
  destination: {fetching: false, data: []},
  guide: {fetching: false, data: []},
  lastest: {fetching: false, data: []},
  trendingList: {fetching: false, data: []},
  detail: {fetching: false},
  footerList: {fetching: false, data: []},
  categories: {fetching: false, data: []},
};

const getJobListRequest: CaseReducer<JobState, PayloadAction<GetJobListParams>> = (state, {payload}) => {
  if (payload.loadingMore) {
    state.list.loadingMore = true;
    return;
  }
  state.list.fetching = true;
  delete state.list.error;
};

const getJobListSuccess: CaseReducer<JobState, PayloadAction<ResponseState<JobItem>>> = (state, {payload}) => {
  if (state.list.loadingMore) {
    state.list.data = [...state.list.data, ...payload.data];
    state.list.loadingMore = false;
  } else {
    state.list.data = payload.data;
    state.list.fetching = false;
  }
  state.list.meta = payload.meta;
};

const getJobListFailed: CaseReducer<JobState, PayloadAction<string>> = (state, {payload}) => {
  state.list.loadingMore = false;
  state.list.fetching = false;
  state.list.error = payload;
};

const getFooterJobRequest: CaseReducer<JobState, PayloadAction<GetJobListParams>> = (state) => {
  delete state.footerList.error;
  state.footerList.fetching = true;
};

const getFooterJobSuccess: CaseReducer<JobState, PayloadAction<ResponseState<JobItem>>> = (state, {payload}) => {
  state.footerList.data = payload.data;
  state.footerList.fetching = false;
  state.footerList.meta = payload.meta;
};

const getFooterJobFailed: CaseReducer<JobState, PayloadAction<string>> = (state, {payload}) => {
  state.footerList.fetching = false;
  state.footerList.error = payload;
};

const getJobDetailRequest: CaseReducer<JobState> = (state) => {
  state.detail.fetching = true;
};

const getJobDetailSuccess: CaseReducer<JobState, PayloadAction<JobItem>> = (state, {payload}) => {
  state.detail.fetching = false;
  state.detail.data = payload;
};

const getJobDetailFailed: CaseReducer<JobState, PayloadAction<string>> = (state, {payload}) => {
  state.detail.fetching = false;
  state.detail.error = payload;
};

const getJobCategoriesRequest: CaseReducer<JobState> = (state) => {
  delete state.categories.error;
  state.categories.fetching = true;
};

const getJobCategoriesSuccess: CaseReducer<JobState, PayloadAction<ResponseState<JobItemCategory>>> = (
  state,
  {payload},
) => {
  state.categories.data = payload.data;
  state.categories.fetching = false;
};

const getJobCategoriesFailed: CaseReducer<JobState, PayloadAction<string>> = (state, {payload}) => {
  state.categories.fetching = false;
  state.categories.error = payload;
};

const getTrendingJobRequest: CaseReducer<JobState> = (state) => {
  delete state.trendingList.error;
  state.trendingList.fetching = true;
};

const getTrendingJobSuccess: CaseReducer<JobState, PayloadAction<ResponseState<JobItem>>> = (
  state,
  {payload},
) => {
  state.trendingList.data = payload.data;
  state.trendingList.fetching = false;
};

const getTrendingJobFailed: CaseReducer<JobState, PayloadAction<string>> = (state, {payload}) => {
  state.trendingList.fetching = false;
  state.trendingList.error = payload;
};

const getDestinationJobRequest: CaseReducer<JobState> = (state) => {
  delete state.destination.error;
  state.destination.fetching = true;
};

const getDestinationJobSuccess: CaseReducer<JobState, PayloadAction<ResponseState<JobItem>>> = (
  state,
  {payload},
) => {
  state.destination.data = payload.data;
  state.destination.fetching = false;
  state.destination.meta = payload.meta;
};

const getDestinationJobFailed: CaseReducer<JobState, PayloadAction<string>> = (state, {payload}) => {
  state.destination.fetching = false;
  state.destination.error = payload;
};

const getGuideJobRequest: CaseReducer<JobState> = (state) => {
  delete state.guide.error;
  state.guide.fetching = true;
};

const getGuideJobSuccess: CaseReducer<JobState, PayloadAction<ResponseState<JobItem>>> = (state, {payload}) => {
  state.guide.data = payload.data;
  state.guide.fetching = false;
  state.guide.meta = payload.meta;
};

const getGuideJobFailed: CaseReducer<JobState, PayloadAction<string>> = (state, {payload}) => {
  state.guide.fetching = false;
  state.guide.error = payload;
};

const getLastestJobRequest: CaseReducer<JobState> = (state) => {
  delete state.lastest.error;
  state.lastest.fetching = true;
};

const getLastestJobSuccess: CaseReducer<JobState, PayloadAction<ResponseState<JobItem>>> = (
  state,
  {payload},
) => {
  state.lastest.data = payload.data;
  state.lastest.fetching = false;
  state.lastest.meta = payload.meta;
};

const getLastestJobFailed: CaseReducer<JobState, PayloadAction<string>> = (state, {payload}) => {
  state.lastest.fetching = false;
  state.lastest.error = payload;
};

const getRelatedJobRequest: CaseReducer<JobState> = (state) => {
  delete state.related.error;
  state.related.fetching = true;
};

const getRelatedJobSuccess: CaseReducer<JobState, PayloadAction<ResponseState<JobItem>>> = (
  state,
  {payload},
) => {
  state.related.data = payload.data;
  state.related.fetching = false;
  state.related.meta = payload.meta;
};

const getRelatedtJobFailed: CaseReducer<JobState, PayloadAction<string>> = (state, {payload}) => {
  state.related.fetching = false;
  state.related.error = payload;
};

const jobSlice = createSlice({
  name: 'jobs',
  initialState,
  reducers: {
    getJobListRequest,
    getJobListSuccess,
    getJobListFailed,

    getJobDetailRequest,
    getJobDetailSuccess,
    getJobDetailFailed,

    getFooterJobRequest,
    getFooterJobSuccess,
    getFooterJobFailed,

    getJobCategoriesRequest,
    getJobCategoriesSuccess,
    getJobCategoriesFailed,

    getTrendingJobRequest,
    getTrendingJobSuccess,
    getTrendingJobFailed,

    getDestinationJobRequest,
    getDestinationJobSuccess,
    getDestinationJobFailed,

    getGuideJobRequest,
    getGuideJobSuccess,
    getGuideJobFailed,

    getLastestJobRequest,
    getLastestJobSuccess,
    getLastestJobFailed,

    getRelatedJobRequest,
    getRelatedJobSuccess,
    getRelatedtJobFailed,
  },
});

export const jobActions = jobSlice.actions;
export const jobReducer = jobSlice.reducer;
